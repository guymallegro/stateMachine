public abstract class AMDState implements IMDState {

    Context context;

    public AMDState(Context context) {
        this.context = context;
    }


    public void enterState() {
        System.out.println("enter" + getClass().toString().replaceAll("class", "") + " state");
    }

    public void exitState() {
        System.out.println("exit" + getClass().toString().replaceAll("class", "") + " state");
    }

    public void turnOn() {

    }

    public void turnOff() {

    }

    public void internetOn() {

    }

    public void internetOff() {

    }

    public void fileRequest() {

    }

    public void downloadFinish() {

    }

    public void downloadError() {

    }

    public void downloadAborted() {

    }

    public void errorFixed() {

    }

    public void downloadDelete() {

    }

    public void movieOn() {

    }

    public void movieOff() {

    }

    public void holdMovie() {

    }

    public void resume() {

    }

    public void restartMovie() {

    }
}
