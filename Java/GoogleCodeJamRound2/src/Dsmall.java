import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Dsmall {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) {
			int words = kb.nextInt();
			int servers = kb.nextInt();
			ArrayList<String> wordList = new ArrayList<>(words);
			
			for(int i = 0; i < words; i++) {
				wordList.add(kb.next());
			}
			
			ArrayList<ArrayList<String>> serverList = new ArrayList<>(servers);
			
			for(int i = 0; i < servers; i++) {
				serverList.add(new ArrayList<String>());
			}
			
			recurse(wordList,serverList,0,0);
			
			System.out.println("Case #" + c + ": " + maxNodes + " " + ways % 1000000007);
		}
	}
		private static int maxNodes = Integer.MIN_VALUE;
		private static long ways = 0;
		
		private static void recurse(ArrayList<String> words, ArrayList<ArrayList<String>> servers, int word, int server) {
			if(word >= words.size()) {
				int nodes = 0;
				
				for(ArrayList<String> sList : servers) {
					nodes += prefixes(sList);
				}
				
				if(nodes > maxNodes) {
					maxNodes = nodes;
					ways = 1;
				} else if (nodes == maxNodes) {
					ways++;
				}
				if(servers.get(server).size() > 0) {
					servers.get(server).remove(servers.get(server).size() - 1);
				}
				return;
			}
				
			if(server < servers.size() - 1) {
				
				if(servers.get(server).size() == 0) {
					servers.get(server).add(words.get(word));
					recurse(words,servers,word + 1,server);
					return;
				}
				
				recurse(words,servers,word,server + 1);
			}
			
			servers.get(server).add(words.get(word));
			
			recurse(words,servers,word + 1,server);
			
			if(servers.get(server).size() > 0) {
				servers.get(server).remove(servers.get(server).size() - 1);
			}
		}
	
		private static int prefixes(ArrayList<String> wordlist) {
			HashMap<String, Boolean> hash = new HashMap<>();
			int output = 1;
			for(int i = 0; i < wordlist.size(); i++) {
				String word = wordlist.get(i);
				for(int j = 0; j < word.length(); j++) {
					String prefix = word.substring(0,j+1);
					
					if(!hash.containsKey(prefix)) {
						output++;
						hash.put(prefix, true);
					}
				}
			}
			return output;
		}

}
