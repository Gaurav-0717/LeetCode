class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Solution {
    TrieNode root = new TrieNode();
    boolean isEnd = false;

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            addWord(s);
        }

        String[] str1 = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String str : str1){
            String s = prefix(str);
            sb.append(s);
            sb.append(" ");
        }

        return sb.toString().trim();

    }

    public void addWord(String str){
        TrieNode curr = root;

        for (char ch : str.toCharArray()) {
                int index = ch - 'a';

                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index]; 
            }

            curr.isEnd = true;
    }

    public String prefix(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (curr.children[index] == null) {
                    return word;
                }

                sb.append(ch);
                curr = curr.children[index]; 


                if(curr.isEnd){
                    return sb.toString();
                }
                
            }

            return word;
    }
}