public class Main {

    public int saveZhenaiCoin2 (int[] grid) {
        // write code here
        int first = 0;
        int length = grid.length;
        int cost = 0;
        int lastCost = 0;
        while (true){
            //
        }




    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] num = {20,30,20};
        System.out.println(main.saveZhenaiCoin(num));
    }
    int minCost = Integer.MAX_VALUE;
    public int saveZhenaiCoin (int[] grid) {
        // write code here
        saveZhenaiCoin(grid, 0, 0);
        saveZhenaiCoin(grid, 1, 0);
        return  minCost;
    }
    public void saveZhenaiCoin(int[] grid,int index,int cost){
        if(grid.length <= index){
            if(cost<minCost){
                minCost = cost;
            }
            return;
        }
        saveZhenaiCoin(grid, index+1, cost+grid[index]);
        saveZhenaiCoin(grid, index+2, cost+grid[index]);
    }
}
