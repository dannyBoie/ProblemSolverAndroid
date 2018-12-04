
package framework.solution;

import framework.graph.Vertex;
import java.util.Stack;


public class Solution {

    public Solution(Vertex start, Vertex end) {
        /* you must provide */
        this.start = start;
        this.end = end;
        storage = new Stack();
        buildStack();
    }


    public int getLength() {
        /* you must provide */
        return storage.size() - 1;
    }

    public boolean hasNext() {
        /* you must provide */
        return getLength() >= 0;
    }


    public Vertex next() {
        /* you must provide */
        if(hasNext()) {
            return (Vertex) storage.pop();
        }
        else {
            throw new RuntimeException("No vertices left");
        }
    }


    private void buildStack() {
        Vertex t = end;
        while(t != null) {
            storage.push(t);
            t = t.getPredecessor();
        }
    }

    private Vertex start, end;
    private Stack storage;

}
