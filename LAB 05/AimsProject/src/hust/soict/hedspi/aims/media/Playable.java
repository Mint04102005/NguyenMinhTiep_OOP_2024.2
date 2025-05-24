package hust.soict.hedspi.aims.media;

public interface Playable {
	public void play() throws PlayerExceptiom{
		if(this.getLength() > 0) {
			Object tracks = new Track();
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}catch(PlayerException e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positice!");
		}
	}

	
}
