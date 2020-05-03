package controllers.view;

import models.figures.Researcher;

public class ResearcherPresenter extends FigurePresenter {
    private Researcher researcher;

    public ResearcherPresenter(Researcher researcher) {
        this.researcher = researcher;
    }

    @Override
    public void draw(int x, int y) {
        //TODO implement draw()
        super.draw(x, y);
    }
}
