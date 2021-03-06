package moxy.compiler;

import com.google.testing.compile.Compilation;
import javax.tools.JavaFileObject;
import org.junit.Test;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.JavaFileObjects.forResource;

public class PresentersBinderErrorTest extends CompilerTest {

    @Test
    public void testNotImplementViewInterface() throws Exception {
        JavaFileObject target = forResource("target/NotImplementViewInterfaceTarget.java");

        Compilation targetCompilation = compileSourcesWithProcessor(target);

        assertThat(targetCompilation)
            .hadErrorContaining(
                "You can not use @InjectPresenter in a class that is not a View typed with target Presenter")
            .inFile(target)
            .onLineContaining("EmptyViewPresenter presenter");
    }
}
