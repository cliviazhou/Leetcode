struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<vector<int> > levelOrder(TreeNode* root){
    
    vector<vector<int>> res;
    
    vector<TreeNode*> v;
    
    if (!root) return res;
    
    v.push_back(root);
    
    long cur = 0, last = 1;
    
    while(cur < v.size()){
        last = v.size();
        vector<int> temp;
        while ( cur < last){
            temp.push_back(v[cur]->val);
            if (v[cur]->left) v.push_back(v[cur]->left);
            if (v[cur]->right) v.push_back(v[cur]->right);
            cur ++;
        }
        
        res.push_back(temp);
    }
    return res;
}