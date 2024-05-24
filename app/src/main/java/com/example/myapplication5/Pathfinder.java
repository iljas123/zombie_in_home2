package com.example.myapplication5;

import android.util.Log;

import java.util.Vector;

public class Pathfinder {

    public static Vector getPath (int startX, int startY, int endX, int endY, int[][] map ) {
        Vector openList = new Vector();
        Vector closeList = new Vector();
        Node startNode = new Node(endX, endY);
        openList.add(startNode);
        while (openList.size() > 0) {
            Node n = (Node) openList.elementAt(0);
            openList.removeElementAt(0);
            closeList.add(n);
            if(n.x == startX && n.y == startY) {
                Node curr = n;
                Vector path = new Vector();
                while(curr != null) {
                    path.add(curr);
                    curr = curr.parent;
                }
                System.out.println(path);
                return path;
            }

            for (int x = n.x - 1; x <= n.x + 1; x++) {
                for (int y = n.y - 1; y <= n.y + 1; y++) {
                    if (x >= 0 && y >= 0 && x < map[0].length && y < map.length) {
                        if (map[y][x] == 0 && !contains(closeList, x, y) ) {
                            if ( !contains(openList, x, y) ) {
                                Node neighbor = new Node(x, y);
                                neighbor.parent = n;
                                openList.add(neighbor);
                                Log.i("i",neighbor.x+" "+neighbor.y);
                            }
                        }
                    }
                }
            }

        }
        return null;
    }
    static boolean contains(Vector list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            Node n = (Node) list.get(i);
            if (n.x == x && n.y == y) return true;
        }
        return false;
    }

// class Node
    /**
     * @author dzanis
     * @version 1.0
     * Класс для узла. Каждый узел имеет координаты x и y и его родителя Node parent
     */
    public static void main(String[] args)
    {int[][] mat =
            {
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0,0,0,0},
                    {0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,1,0,0,0,0,1,1,1,0,1,1,1,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
            };
        Pathfinder pf = new Pathfinder();
        Vector path = pf.getPath(0, 0, 5, 5, mat);
        for (int i = 0; i < path.size(); i++) {
            Node n =  (Node) path.elementAt(i);
            System.out.println(n.x+" "+n.y);
        }
    }
}
class Node {
    public int x;
    public int y;
    Node parent = null;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}