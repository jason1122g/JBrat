package app.view

import demo.src.main.groovy.app.helper.LaunchHelper
import org.jbrat.core.data.abstracts.Bindable
import org.jbrat.views.JBratView

import javax.swing.*
import java.awt.*

@Mixin(LaunchHelper)
class LaunchView extends JBratView{

    private Bindable bean
    private JFrame   frame
    private JPanel   panel

    @Override
    void render(Bindable bean) {
        this.bean = bean
        initFrame()
        initPanel()
        initLabel()
        addComponents()
    }

    private void initFrame(){
        frame = new JFrame(t("title"))
        frame.setSize(300,400)
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        frame.setVisible(true)
    }

    private void initPanel(){
        panel = new JPanel()
        panel.setLayout(new FlowLayout())
    }

    private void initLabel(){
        JLabel label1 = new JLabel()
        label1.setText(decorate(t("msg")))
        panel.add(label1)

        JLabel label2 = new JLabel()
        label2.setText(bean.fromController + "")
        panel.add(label2)
    }

    private void addComponents(){
        frame.setContentPane(panel)
        frame.revalidate()
    }


}
