package model;

import java.util.ArrayList;

public class Festival extends Entity{
	
	ArrayList<Scene> scenes;

	public Festival(String name) {
		super(name);
	}

	public ArrayList<Scene> getScenes() {
		return scenes;
	}

	public void setScenes(ArrayList<Scene> scenes) {
		this.scenes = scenes;
	}

	@Override
	public String toString() {
		return "Festival [scenes=" + scenes + "]";
	}

	
	
}
