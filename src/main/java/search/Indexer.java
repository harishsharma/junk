package search;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer implements Closeable {

    private final IndexWriter indexWriter;

    public Indexer(String indexDir) throws IOException {
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        IndexWriterConfig cfg = new IndexWriterConfig(new StandardAnalyzer());
        this.indexWriter = new IndexWriter(directory, cfg);
    }

    public static void main(String[] args) throws IOException {
        String dataDir = "/Users/harish.sharma/inmobi/";
        String indexDir = "/tmp/indexes";
        Indexer writer = new Indexer(indexDir);
        writer.index(Paths.get(dataDir), new JavaFilesFilter());
        writer.close();

    }

    public int index(Path dataDir, FileFilter fileFilter) throws IOException {
        Files.walk(dataDir).filter(file -> fileFilter.accept(file.toFile())).forEach(file -> {
            try {
                indexFile(file.toFile());
            } catch (Exception e) {}
        });
        indexWriter.commit();
        return indexWriter.numDocs();
    }

    private void indexFile(File file) throws IOException {
        System.out.println("Indexing " + file.getCanonicalPath());
        Document doc = new Document();
        doc.add(new StringField("path", file.toPath().toString(), Field.Store.YES));
        doc.add(new TextField("content", new BufferedReader(new FileReader(file))));
        // indexWriter.addDocument(doc);
        indexWriter.updateDocument(new Term("path", file.toPath().toString()), doc);
    }

    @Override
    public void close() throws IOException {
        indexWriter.close();
    }


    public static class JavaFilesFilter implements FileFilter {
        public boolean accept(File path) {
            return path.getName().toLowerCase().endsWith(".java");
        }
    }
}
