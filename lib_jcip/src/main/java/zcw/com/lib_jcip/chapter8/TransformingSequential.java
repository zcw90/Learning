package zcw.com.lib_jcip.chapter8;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 朱城委 on 2019/11/26.<br><br>
 */
public abstract class TransformingSequential {

    void processSequentially(List<Element> elements) {
        for (Element element : elements) {
            process(element);
        }
    }

    void processInParallel(Executor exec, List<Element> elements) {
        for(final Element element : elements) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    process(element);
                }
            });
        }
    }

    public abstract void process(Element element);

    public <T> void sequentialRecursive(List<Node<T>> nodes, Collection<T> result) {
        for(Node<T> node : nodes) {
            result.add(node.compute());
            sequentialRecursive(node.getChildren(), result);
        }
    }

    public <T> void parallelRecursive(Executor exec, List<Node<T>> nodes, final Collection<T> result) {
        for(final Node<T> node : nodes) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    result.add(node.compute());
                }
            });

            parallelRecursive(exec, node.getChildren(), result);
        }
    }

    public <T> Collection<T> getParalleResult(List<Node<T>> nodes) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Queue<T> resultQueue = new ConcurrentLinkedDeque<>();
        parallelRecursive(exec, nodes, resultQueue);
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        return resultQueue;
    }

    interface Element {

    }

    interface Node<T> {
        T compute();

        List<Node<T>> getChildren();
    }
}
