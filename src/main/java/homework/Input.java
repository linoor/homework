package homework;

public class Input {
    private int[] rooms;
    private int senior;

    public Input(int[] rooms, int senior, int junior) {
        this.rooms = rooms;
        this.senior = senior;
        this.junior = junior;
    }

    public int[] getRooms() {
        return rooms;
    }

    public int getSenior() {
        return senior;
    }

    public int getJunior() {
        return junior;
    }

    private int junior;


}
