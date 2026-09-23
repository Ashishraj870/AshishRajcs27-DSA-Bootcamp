class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0 ) return null;
        return getBST(nums, 0, nums.length-1);
    } 
        public TreeNode getBST(int[] nums, int start, int end) {
            int mid = (start+end)/2;
            if(start > end) return null;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = getBST(nums ,start, mid-1);
            root.right = getBST(nums, mid+1, end); 
            return root;  
        }
        
    }
