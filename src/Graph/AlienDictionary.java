package Graph;

import java.util.Arrays;

/**
 * Created by shiyanch on 1/4/17.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        int n = 26;
        int[][] adj = new int[n][n];
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for (String word : words) {
            for (char c : word.toCharArray()) {
                visited[c-'a'] = 0;
            }
        }

        buildGraph(words, adj, visited);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (visited[i] == 0 && !dfs(adj, i, visited, sb)) {
                return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(int[][] adj, int start, int[] visited, StringBuilder sb) {
        visited[start] = 1;
        for (int i=0; i<26; i++) {
            if (adj[start][i] == 1) {
                if (visited[i] == 1) {
                    return false;
                }
                if (visited[i] == 0 && !dfs(adj, i, visited, sb)) {
                    return false;
                }
            }
        }
        visited[start] = 2;
        sb.append((char)(start+'a'));
        return true;
    }

    private void buildGraph(String[] words, int[][] adj, int[] visited) {
        for (int i=1; i<words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];
            if (word1.startsWith(word2) && !word1.equals(word2)) {
                Arrays.fill(visited, 2);
                return;
            }

            int len = Math.min(word1.length(), word2.length());
            for (int index=0; index<len; index++) {
                if (word1.charAt(index) != word2.charAt(index)) {
                    adj[word1.charAt(index)-'a'][word2.charAt(index)-'a'] = 1;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"za","zb","ca","cb"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }
}
