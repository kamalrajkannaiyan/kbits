package org.kml.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TriesBasics {
    public static void main(String[] args) {
        // Create a Trie object
        Trie trie = new Trie();

        // Define input operations and arguments
        List<String> operations = Arrays.asList("Trie", "insert", "search", "search", "startsWith", "insert", "search");
        List<List<String>> arguments = Arrays.asList(
                Collections.emptyList(),
                Collections.singletonList("apple"),
                Collections.singletonList("apple"),
                Collections.singletonList("app"),
                Collections.singletonList("app"),
                Collections.singletonList("app"),
                Collections.singletonList("app")
        );

        // Execute operations
        List<String> output = new ArrayList<>();
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).equals("Trie")) {
                output.add("null");
            } else if (operations.get(i).equals("insert")) {
                trie.insert(arguments.get(i).get(0));
                output.add("null");
            } else if (operations.get(i).equals("search")) {
                boolean result = trie.search(arguments.get(i).get(0));
                output.add(result ? "true" : "false");
            } else if (operations.get(i).equals("startsWith")) {
                boolean result = trie.startsWith(arguments.get(i).get(0));
                output.add(result ? "true" : "false");
            }
        }

        // Print output
        for (String res : output) {
            System.out.println(res);
        }
    }
}

class Node{
    Node[] nodes = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch)
    {
        return nodes[ch - 'a'] != null;
    }
    void put(char ch, Node node)
    {
        nodes[ch - 'a'] = node;
    }
    Node get(char ch)
    {
        return nodes[ch - 'a'];
    }
    void setEnd()
    {
        flag = true;
    }
    boolean isEnd()
    {
        return flag;
    }
}
class Trie {
    Node root;
    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node curr = root;
        for(int idx = 0; idx < word.length(); idx++)
        {
            char ch = word.charAt(idx);
            if(!curr.containsKey(ch))
            {
                curr.put(ch, new Node());
            }
            // move to next char
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    boolean search(String word) {
        Node curr = root;
        for(int idx = 0; idx < word.length(); idx++)
        {
            char ch = word.charAt(idx);
            if(curr.containsKey(ch))
                curr = curr.get(ch);
            else
                return false;
        }
        return curr.isEnd();
    }

    boolean startsWith(String prefix) {
        Node curr = root;
        for(int idx = 0; idx < prefix.length(); idx++)
        {
            char ch = prefix.charAt(idx);
            if(curr.containsKey(ch))
                curr = curr.get(ch);
            else
                return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
