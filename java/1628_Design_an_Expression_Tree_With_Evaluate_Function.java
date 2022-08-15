/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class Numbers extends Node {
    final int num;
    Numbers(String s) {
        num = Integer.parseInt(s);
    }
    public int evaluate() {
        return num;
    }
}

class Operators extends Node {
    final Node num1, num2;
    final BiFunction<Integer, Integer, Integer> bf;
    Operators(Node num1, Node num2, BiFunction<Integer, Integer, Integer> bf) {
        this.num1 = num1;
        this.num2 = num2;
        this.bf = bf;
    }
    public int evaluate() {
        return bf.apply(num1.evaluate(), num2.evaluate());
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Map<String, BiFunction<Integer, Integer, Integer>> map = Map.of("+", (a,b)->a+b, "-", (a,b)->a-b, "*", (a,b)->a*b, "/", (a,b)->a/b);
        Stack<Node> stack = new Stack<>();
        for (String s : postfix) {
            if (map.containsKey(s)) {
                Node num2 = stack.pop();
                Node num1 = stack.pop();
                stack.push(new Operators(num1, num2, map.get(s)));
            } else {
                stack.push(new Numbers(s));
            }
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */