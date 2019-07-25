/***
 *              0123..........26
 *              |||||||||.....||
 *              /
 *            |a||||..|z|
 *            /
 *  |||||...|n|..||
 *           \
 *        ||||d||...||
 *             \
 *             EOW
 */

public class TrieNode {
    TrieNode[] elements = new TrieNode[27];
    boolean endOfWord;
    public TrieNode() {
        for(int i = 0; i< 27; i++) {
            elements[i] = null;
        }
        endOfWord = false;
    }
}
