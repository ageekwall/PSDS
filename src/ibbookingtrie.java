import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ibbookingtrie {

    public static void main(String[] args) {
        String S = "cool_ice_wifi";
        String R[] =new String[] {"water_is_cool", "cold_ice_drink", "cool_wifi_speed"};
        ibbookingtrie i= new ibbookingtrie();
        System.out.println(  i.solve(S, R));

    }

    public void insertIntoTrie(TrieNode node, String key) {
        int l = key.length();
        TrieNode crawler = node;
        for(int i = 0; i < l ; i++) {
            char c = key.charAt(i);
            int index = c -'a';
            if(crawler.elements[index] == null) {
                crawler.elements[index] = new TrieNode();
            }
            crawler = crawler.elements[index];
        }
        crawler.endOfWord = true;
    }

    public boolean searchInTrie(TrieNode node, String key) {
        int l = key.length();
        for(int i = 0; i < l; i++) {
          char c = key.charAt(i);
          int in = c - 'a';
          if(node.elements[in] != null) {
              node = node.elements[in];
          }
          else {
              return false;
          }
        }
        return  node !=null && node.endOfWord;
    }

    private  ArrayList<Integer> solve(String A, String [] B) {
        class GoodValue {
            int goodnessValue;
            String review;
            int index;

            GoodValue(int index, int g, String r) {
                this.goodnessValue = g;
                this.review = r;
                this.index = index;
            }
        }
        String goodWords[] = A.split("_");
        TrieNode trieNode = new TrieNode();
        for (String s : goodWords)
            insertIntoTrie(trieNode, s);

        List<GoodValue> array = new ArrayList<>();
        int i = 0;
        for (String b : B) {
            int s = getGoodness(b, trieNode);
            array.add(new GoodValue(i, s, b));
            i++;
        }

        Collections.sort(array, (x, y) -> { if (x.goodnessValue == y.goodnessValue) return x.index - y.index; else  return y.goodnessValue - x.goodnessValue; });
        ArrayList<Integer>res= new ArrayList<>();
         for(GoodValue g: array) {
             res.add(g.index);
         }
        return res;

    }
    public int getGoodness(String review, TrieNode node) {
        String reviewWrds[] = review.split("_");
        int c = 0;
        for(String re : reviewWrds) {
            if(searchInTrie(node,re))
                c++;
        }
        return c;
    }

}