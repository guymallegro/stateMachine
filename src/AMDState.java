public abstract class AMDState implements IMDState {

    Context context;

    public AMDState(Context context) {
        this.context = context;
    }

    @Override
    public void enterState() {
        System.out.println("enter " + getClass().toString());
    }

    @Override
    public void exitState() {
        System.out.println("exit " + getClass().toString());
    }

    @Override
    public void internetOn() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadFinish() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void downloadAbort() {

    }

    @Override
    public void downloadFixed() {

    }

    @Override
    public void downloadDelete() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void pauseMovie() {

    }

    @Override
    public void resumeMovie() {

    }

    @Override
    public void restartMovie() {

    }
}
