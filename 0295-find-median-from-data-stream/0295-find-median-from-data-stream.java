class MedianFinder {
    private PriorityQueue<Integer> left; //maxHeap
    private PriorityQueue<Integer> right; //minHeap
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num < left.peek()) left.add(num);
        else right.add(num);

        if(Math.abs(left.size()-right.size())>1) right.add(left.poll());
        else if(left.size()<right.size()) left.add(right.poll());
    }
    
    public double findMedian() {
        if(left.size()==right.size()) return (double)(left.peek()+right.peek())/2;
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */