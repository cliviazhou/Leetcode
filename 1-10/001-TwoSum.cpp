class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        // A map used as hashtable can make pair of key and value.
        // To travel the vector, you can hash the element to index.
        map<int,int> m;
        vector<int> index;
        for (int i = 0; i < numbers.size(); i++){
            m[numbers[i]] = i + 1;
        }
        
        for (int i = 0; i < numbers.size(); i++){
            
            int a = numbers[i];
            int b = target - a;
            auto itr = m.find(b);
            if (itr != m.end()){
                int index1 = i + 1;
                int index2 = itr -> second;
                if (index1 < index2){
                    index.push_back(index1);
                    index.push_back(index2);
                }
                else continue;
            }
        }
        return index;
    }
};