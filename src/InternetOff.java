public class InternetOff extends AMDState {

    public InternetOff(Context context) {
        super(context);
    }

    @Override
    public void internetOn() {
        context.setInternetCurrentState(context.internetOn);
    }
}
