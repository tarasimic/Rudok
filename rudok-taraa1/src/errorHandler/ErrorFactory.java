package errorHandler;

import observer.IPublisher;
import observer.ISubscriber;
import view.MainFrame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ErrorFactory implements IPublisher {
    ArrayList<ISubscriber> subscribers = new ArrayList<>();
    private static ErrorFactory instance = null;

    private ErrorFactory(){

    }

    public static ErrorFactory getInstance(){
        if(instance == null){
            instance = new ErrorFactory();

        }
        return instance;
    }

    public void generateError(ErrorType type){

        if(type == ErrorType.SELECT){
            notifySubscriber(new MyError("You need to select node"), "cvor");
            return;
        }
        if(type == ErrorType.AUTOR){
            notifySubscriber(new MyError("You need to select presentation"), "autor");
            return;
        }
        if(type == ErrorType.RENAME){
            notifySubscriber(new MyError("You can't rename workspace"), "rename");
        }
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(subscriber == null){
            return;
        }
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if(subscribers.contains(subscriber)){
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscriber(Object notification, String akcija) {
        for(ISubscriber sub : subscribers){
            sub.update(notification, akcija);
        }
    }
}
