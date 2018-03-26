package school.management.elasticsearch.common;

public interface EsConfig {

    String NUMBER_OF_SHARDS = "index.number_of_shards";

    String NUMBER_OF_REPLICAS = "index.number_of_replicas";

    String PROPERTIES = "properties";

    String EL_TYPE = "type";

    String El_STRING = "text";

    String El_KEYWORD = "keyword";

    String El_INTEGER = "integer";

    String El_LONG = "long";

    String El_DOUBLE = "double";

    String EL_BOOLEAN = "boolean";

    String EL_DATE = "date";


    interface EsSearchConfig{
        String SEARCH_TITLE = "title";
    }

    interface EsTimeFormatConfig{
        String DEFAULT_FORMAT = "yyyy-MM-dd";
    }

    interface AnalyzerConfig{
        String ANALYZER = "analyzer";
        String SEARCH_ANALYZER = "search_analyzer";

        String IK = "ik_max_word";
        String IK_SEARCH = "ik_max_word";

    }

}
