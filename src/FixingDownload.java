public class FixingDownload extends AMDState {
    public FixingDownload(Context context) {
        super(context);
    }

    @Override
    public void enterState() {
        super.enterState();
        context.time = 0;
    }

    @Override
    public void downloadDelete() {
        context.isEnoughSpace = true;
        if (context.filesInQueue == 0) {
            if (context.userPoints > 0)
                context.userPoints--;
            context.setDownloadCurrentState(context.waitingForDownload);
        } else
            context.setDownloadCurrentState(context.downloading);
    }

    @Override
    public void errorFixed() {
        context.setDownloadCurrentState(context.downloading);
    }
}
