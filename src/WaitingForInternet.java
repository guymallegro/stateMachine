public class WaitingForInternet extends AMDState {
    public WaitingForInternet(Context context) {
        super(context);
    }

    @Override
    public void internetOn() {
        context.setDownloadCurrentState(context.downloading);
    }
}
