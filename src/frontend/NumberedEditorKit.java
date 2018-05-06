package frontend;


import javax.swing.text.StyledEditorKit;
import javax.swing.text.ViewFactory;

class NumberedEditorKit extends StyledEditorKit {
    @Override
    public ViewFactory getViewFactory() {
    return new NumberedViewFactory();
    }
}