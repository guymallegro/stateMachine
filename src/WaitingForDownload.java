public class WaitingForDownload extends AMDState {
    public WaitingForDownload(Context context) {
        super(context);
    }

    @Override
    public void enterState() {
        super.enterState();
        context.downloadPercentage = 0;
    }

    @Override
    public void fileRequest() {
        if (context.isEnoughSpace)
            context.setDownloadCurrentState(context.pauseDownload);
        else if (context.isEnoughSpace && context.isInternetConnected) {
            context.setDownloadCurrentState(context.downloading);
        }
    }
}
