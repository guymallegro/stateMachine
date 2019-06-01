public class Downloading extends AMDState {
    public Downloading(Context context) {
        super(context);
    }

    @Override
    public void downloadFinish() {
        context.userPoints++;
        if (context.filesInQueue == 0)
            context.setDownloadCurrentState(context.waitingForDownload);
        else if (context.isEnoughSpace)
            context.setDownloadCurrentState(context.downloading);
        else {
            context.setDownloadCurrentState(context.pauseDownload);
        }

        if (context.userPoints < 4)
            context.setUserCurrentState(context.begginerUser);
        else if (context.userPoints >= 4 && context.userPoints < 7)
            context.setUserCurrentState(context.advancedUser);
        else
            context.setUserCurrentState(context.professionalUser);
    }

    @Override
    public void downloadAborted() {
        if (context.userPoints > 0)
            context.userPoints--;
        if (context.filesInQueue > 0 && !context.isEnoughSpace)
            context.setDownloadCurrentState(context.waitingForDownload);
        else
            context.setDownloadCurrentState(context.downloading);

        if (context.userPoints < 4)
            context.setUserCurrentState(context.begginerUser);
        else if (context.userPoints >= 4 && context.userPoints < 7)
            context.setUserCurrentState(context.advancedUser);
        else
            context.setUserCurrentState(context.professionalUser);
    }

    @Override
    public void downloadError() {
        context.setDownloadCurrentState(context.fixingDownload);
    }

    @Override
    public void internetOff() {
        context.setDownloadCurrentState(context.waitingForInternet);
    }
}
