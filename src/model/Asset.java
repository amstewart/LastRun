package model;

public abstract class Asset {
	String id;

	public Asset(String id) {
		super();
		this.id = id;
	}

	public String getAssetID() {
		return id;
	}

	public void setAssetID(String id) {
		this.id = id;
	}
}
