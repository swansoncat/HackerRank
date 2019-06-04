	public static int getHeight(Node root){
      if (root == null) 
      {
          return 0;
      }
      else
      {
        int i = 0, j = 0;
        if (root.left != null)
        {
            i = 1 + getHeight(root.left);
        }
        if (root.right != null)
        {
            j = 1 + getHeight(root.right);
        }

        if (i > j)
        {
            return i;
        }
        else{
            return j;
        }
      }
    }
