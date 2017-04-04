package com.example.unknown.travistutorial;

import android.content.Context;

/**
 * Created by UNKNOWN on 6/24/2016.
 */
public class CollapseListProvider {

    private String heading;
    private String description;
    private boolean visible;

    Context context;

    public CollapseListProvider(String heading,String description){
        this.setHeading(heading);
        this.setDescription(description);
    }

    public CollapseListProvider(Context context) {
        this.context = context;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
