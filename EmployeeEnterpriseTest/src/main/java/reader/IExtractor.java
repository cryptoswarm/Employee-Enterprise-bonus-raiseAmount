package reader;

import enterprise.IEnterprise;
import manger.ICreator;

public interface IExtractor {
    void readFile(String fileName, ICreator creator, IEnterprise enterprise);
}
