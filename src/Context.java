public class Context {

    public boolean isInternetConnected = true;
    public int filesInQueue = 0;
    public boolean isEnoughSpace = true;
    public int downloadPercentage = 0;
    public boolean isMoviePaused = false;
    public int userPoints = 0;
    public int time = 0;
    public int stoppedAtFrame = 0;

    IMDState internetCurrentState;
    IMDState downloadCurrentState;
    IMDState movieCurrentState;
    IMDState userCurrentState;

    IMDState internetOn;
    IMDState internetOff;

    IMDState waitingForDownload;
    IMDState downloading;
    IMDState fixingDownload;
    IMDState waitingForInternet;
    IMDState pauseDownload;

    IMDState playingMovie;
    IMDState waitingToPlay;
    IMDState pausedMovie;

    IMDState begginerUser;
    IMDState advancedUser;
    IMDState professionalUser;


    public Context() {
        internetOn = new InternetOn(this);
        internetOff = new InternetOff(this);

        waitingForDownload = new WaitingForDownload(this);
        pauseDownload = new PauseDownload(this);
        downloading = new Downloading(this);
        fixingDownload = new FixingDownload(this);
        waitingForInternet = new WaitingForInternet(this);

        playingMovie = new PlayingMovie(this);
        waitingToPlay = new WaitingToPlay(this);
        pausedMovie = new PausedMovie(this);

        begginerUser = new BegginerUser(this);
        advancedUser = new AdvancedUser(this);
        professionalUser = new ProfessionalUser(this);

        internetCurrentState = internetOff;
        downloadCurrentState = waitingForDownload;
        movieCurrentState = waitingToPlay;
        userCurrentState = begginerUser;
    }


    public void setInternetCurrentState(IMDState newState) {
        internetCurrentState.exitState();
        internetCurrentState = newState;
        internetCurrentState.enterState();
    }

    public void setDownloadCurrentState(IMDState newState) {
        downloadCurrentState.exitState();
        downloadCurrentState = newState;
        downloadCurrentState.enterState();
    }

    public void setMovieCurrentState(IMDState newState) {
        movieCurrentState.exitState();
        movieCurrentState = newState;
        movieCurrentState.enterState();
    }

    public void setUserCurrentState(IMDState newState) {
        userCurrentState.exitState();
        userCurrentState = newState;
        userCurrentState.enterState();
    }

    public void setInternetOn() {
        isInternetConnected = true;
        internetCurrentState.internetOn();
        downloadCurrentState.internetOn();
        movieCurrentState.internetOn();
        userCurrentState.internetOn();
    }

    public void setInternetOff() {
        isInternetConnected = false;
        internetCurrentState.internetOff();
        downloadCurrentState.internetOff();
        movieCurrentState.internetOff();
        userCurrentState.internetOff();
    }

    public void fileRequest() {
        internetCurrentState.fileRequest();
        downloadCurrentState.fileRequest();
        movieCurrentState.fileRequest();
        userCurrentState.fileRequest();
    }

    public void downloadFinish() {
        internetCurrentState.downloadFinish();
        downloadCurrentState.downloadFinish();
        movieCurrentState.downloadFinish();
        userCurrentState.downloadFinish();
    }

    public void downloadAbort() {
        internetCurrentState.downloadAborted();
        downloadCurrentState.downloadAborted();
        movieCurrentState.downloadAborted();
        userCurrentState.downloadAborted();
    }

    public void downloadError() {
        internetCurrentState.downloadError();
        downloadCurrentState.downloadError();
        movieCurrentState.downloadError();
        userCurrentState.downloadError();
    }

    public void downloadFixed() {
        internetCurrentState.errorFixed();
        downloadCurrentState.errorFixed();
        movieCurrentState.errorFixed();
        userCurrentState.errorFixed();
    }

    public void downloadDelete() {
        isEnoughSpace = true;
        internetCurrentState.downloadDelete();
        downloadCurrentState.downloadDelete();
        movieCurrentState.downloadDelete();
        userCurrentState.downloadDelete();
    }

    public void movieOn() {
        internetCurrentState.movieOn();
        downloadCurrentState.movieOn();
        movieCurrentState.movieOn();
        userCurrentState.movieOn();

    }

    public void movieOff() {
        internetCurrentState.movieOff();
        downloadCurrentState.movieOff();
        movieCurrentState.movieOff();
        userCurrentState.movieOff();
    }

    public void pauseMovie() {
        internetCurrentState.holdMovie();
        downloadCurrentState.holdMovie();
        movieCurrentState.holdMovie();
        userCurrentState.holdMovie();
    }

    public void resumeMovie() {
        internetCurrentState.resume();
        downloadCurrentState.resume();
        movieCurrentState.resume();
        userCurrentState.resume();
    }

    public void restartMovie() {
        internetCurrentState.resume();
        downloadCurrentState.restartMovie();
        movieCurrentState.restartMovie();
        userCurrentState.restartMovie();
    }

    public void increaseTime() {
        time++;
        if (time == 3 && downloadCurrentState instanceof FixingDownload) {
            setDownloadCurrentState(waitingForDownload);

        } else if (time == 4 && downloadCurrentState instanceof PauseDownload && !isEnoughSpace) {
            setDownloadCurrentState(waitingForDownload);

        } else if (time == 4 && downloadCurrentState instanceof PauseDownload && isEnoughSpace && isInternetConnected) {
            setDownloadCurrentState(downloading);
        }
    }
}
