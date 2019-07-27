import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {

    public static void main(String[] args) {
        ArrayList a = new ArrayList<String>();
        //TESTs
        a.add("OOOXOOO");
        a.add("OOXXOXO");
        a.add("OXOOOXO");
        System.out.println(solve(a));
    }

    public static int solve(ArrayList<String> graph) {
        int l = graph.size();
        int s = graph.get(0).length();
        Element e[][] = new Element[l + 1][s + 1];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < s; j++) {
                e[i][j] = new Element(i, j, 0, graph.get(i).charAt(j));
            }
        }
        int res = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < s; j++) {
                if (e[i][j].vis == 0 && e[i][j].c == 'X') {
                    e[i][j].vis = 1;
                    res += bfs(e, e[i][j]);
                }
            }
        }
        return res;
    }

    private static int bfs(Element[][] el, Element e) {
        Queue<Element> q = new LinkedList<>();
        ((LinkedList<Element>) q).push(e);
        while (!q.isEmpty()) {
            Element ee = ((LinkedList<Element>) q).pop();
            int i = ee.i;
            int j = ee.j;
            if (i > 0 && el[i - 1][j].c == 'X' && el[i - 1][j].vis == 0) {
                el[i - 1][j].vis = 1;
                ((LinkedList<Element>) q).push(el[i - 1][j]);
            }
            if (i < el.length - 2 && el[i + 1][j].c == 'X' && el[i + 1][j].vis == 0) {
                el[i + 1][j].vis = 1;
                ((LinkedList<Element>) q).push(el[i + 1][j]);
            }
            if (j > 0 && el[i][j - 1].c == 'X' && el[i][j - 1].vis == 0) {
                el[i][j - 1].vis = 1;
                ((LinkedList<Element>) q).push(el[i][j - 1]);
            }
            if (j < el[0].length - 2 && el[i][j + 1].c == 'X' && el[i][j + 1].vis == 0) {
                el[i][j + 1].vis = 1;
                ((LinkedList<Element>) q).push(el[i][j + 1]);
            }
        }
        return 1;
    }
}

class Element {
    int i, j;
    int vis;
    char c;

    public Element(int i, int j, int vis, char c) {
        this.i = i;
        this.j = j;
        this.vis = vis;
        this.c = c;
    }
}