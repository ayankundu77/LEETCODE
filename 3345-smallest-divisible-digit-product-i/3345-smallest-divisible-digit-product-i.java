class Solution {
    public int prodDigits(int x){
        int product = 1;
        while(x>0){
            product*=(x%10);
            x/=10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        for(int num=n;num<=n+9;num++){
            if(prodDigits(num)%t==0) return num;
        }
        return -1;
    }
}