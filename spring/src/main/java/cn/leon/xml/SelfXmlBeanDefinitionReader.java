package cn.leon.xml;

import cn.leon.SelfBeanDefinition;
import cn.leon.SelfBeanReference;
import cn.leon.resource.SelfResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SelfXmlBeanDefinitionReader implements SelfBeanDefinitionReader {

    private final Map<String, SelfBeanDefinition> beanDefinitionMap = new HashMap<String, SelfBeanDefinition>();

    public SelfXmlBeanDefinitionReader(SelfResource resource){
        loadBeanDefinition(resource);
    }

    @Override
    public void loadBeanDefinition(SelfResource resource) {
        InputStream inputStream = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            inputStream = resource.getInputStream();
            Document document = documentBuilder.parse(inputStream);
            registerBeanDefinitions(document);
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 遍历xml元素，设置属性以及注册bean
     * @param document
     */
    private void registerBeanDefinitions(Document document){
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for(int i=0; i<nodeList.getLength(); ++i){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element beanNode = (Element) node;
                String id = beanNode.getAttribute("id");
                String className = beanNode.getAttribute("class");
                SelfBeanDefinition beanDefinition = new SelfBeanDefinition(className);
                //设置属性
                processProperties(beanNode, beanDefinition);
                //注册Bean
                beanDefinitionMap.put(id, beanDefinition);
            }
        }
    }

    /**
     * 读取properties
     * @param beanNode
     * @param beanDefinition
     */
    private void processProperties(Element beanNode, SelfBeanDefinition beanDefinition){
        NodeList nodeList = beanNode.getChildNodes();
        for(int i=0; i<nodeList.getLength(); ++i){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element propertyNode = (Element) node;
                String propertyName = propertyNode.getAttribute("name");
                String propertyValue = propertyNode.getAttribute("value");
                if(null!=propertyValue && propertyValue.length()>0) {
                    beanDefinition.setProperty(propertyName, propertyValue);
                }else{
                    /**
                     * 遇到ref先使用SelfBeanReference占位
                     */
                    String propertyRef = propertyNode.getAttribute("ref");
                    beanDefinition.setProperty(propertyName, new SelfBeanReference(propertyRef));
                }
            }
        }
    }
    public Map<String, SelfBeanDefinition> getBeanDefinitionMap(){
        return beanDefinitionMap;
    }
}
