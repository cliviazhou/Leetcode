void nextPermutation(vector<int> &num){
    
    int size = int(num.size());
    int i, j;
    
    for (j = size - 2; j >= 0; j--){
        if( num[j] < num[j + 1]) break;
        
    }
    
    if (j >= 0){
        for (i = size - 1; i > j; i--)
            if (num[i] > num[j]) break;
        
        swap(num[i],num[j]);
    }
    reverse(num.begin() + j + 1, num.end());
    
}
