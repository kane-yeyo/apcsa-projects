package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model.getHeight(), 0, 2, 1); //starting tower, ending tower, middle tower
    }

    private void solve(int n, int startingTower, int endingTower, int middleTower) {
        if (n == 0) {
            return; //no disks to move
        }

        solve(n-1, startingTower, middleTower, endingTower); //move n-1 disks from the starting tower to the middle tower

        model.move(startingTower, endingTower); //move the nth disk from the starting tower to the ending tower

        solve(n-1, middleTower, endingTower, startingTower); //move n-1 disks from the middle tower to the ending tower
    }
}
