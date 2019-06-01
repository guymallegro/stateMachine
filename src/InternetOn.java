public class InternetOn extends AMDState {
    public InternetOn(Context context) {
        super(context);
    }

    @Override
    public void internetOff() {
        context.setInternetCurrentState(context.internetOff);
    }
}
