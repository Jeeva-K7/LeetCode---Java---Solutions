class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int i=0, j=0, l=0;
        char arr[][]=new char[numRows][s.length()];
        int flag=0;
        while(l<s.length()){
            //Going Down
            if(flag==0){
                while(i<numRows && l<s.length()){
                    arr[i][j]=s.charAt(l);
                    i++;
                    l++;
                }
                i--;
                flag=1;
            }

            //Diagonal Up
            if(flag==1){
                while(i>0 && l<s.length()){
                    i--;
                    j++;
                    arr[i][j]=s.charAt(l);
                    l++; 
                }
                flag=0;
                i++;
            }
        }

        String res="";
        for(int row=0; row<numRows; row++){
            for(int col=0; col<s.length(); col++){
                if(arr[row][col]!='\u0000'){
                    res+=arr[row][col];
                }
            }
        }

        return res;
    }
}
