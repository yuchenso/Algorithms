class MinStack extends Stack {
    public class NodeWithMin {
        public int value;
        public int min;
        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    
    public void push(int x) {
        if (this.isEmpty()) {
            super.push(new NodeWithMin(x, x));
        }
        else {
            super.push(new NodeWithMin(x, Math.min(this.top(), x)));
        }
    }

    public void pop() {
        super.pop();
    }

    public int top() {
        return super.peek().value;
    }

    public int getMin() {
        return super.peek().min;
    }
}
