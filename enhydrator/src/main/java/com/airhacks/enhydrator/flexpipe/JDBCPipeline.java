package com.airhacks.enhydrator.flexpipe;

import com.airhacks.enhydrator.in.JDBCSource;
import com.airhacks.enhydrator.out.Sink;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author airhacks.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "jdbc-pipeline")
public class JDBCPipeline implements Pipeline {

    private String name;
    private JDBCSource source;

    @XmlElement(name = "sql-query")
    private String sqlQuery;

    @XmlElement(name = "query-param")
    private List<Object> queryParams;
    private Sink sink;

    @XmlElement(name = "pre-row-transformer")
    private List<String> preRowTransformers;

    @XmlElement(name = "entry-transformation")
    private List<EntryTransformation> entryTransformations;

    @XmlElement(name = "post-row-transformer")
    private List<String> postRowTransfomers;

    @XmlElement(name = "expression")
    private List<String> expressions;

    JDBCPipeline() {
        this.preRowTransformers = new ArrayList<>();
        this.entryTransformations = new ArrayList<>();
        this.postRowTransfomers = new ArrayList<>();
        this.queryParams = new ArrayList<>();
        this.expressions = new ArrayList<>();
    }

    public JDBCPipeline(String name, String sqlQuery, JDBCSource source, Sink sink) {
        this();
        this.preRowTransformers = new ArrayList<>();
        this.sqlQuery = sqlQuery;
        this.name = name;
        this.source = source;
        this.sink = sink;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addPreRowTransforation(String transformer) {
        this.preRowTransformers.add(transformer);
    }

    public void addEntryTransformation(EntryTransformation et) {
        this.entryTransformations.add(et);
    }

    public void addPostRowTransformation(String transformer) {
        this.postRowTransfomers.add(transformer);
    }

    public void addExpression(String expression) {
        this.expressions.add(expression);
    }

    public void addQueryParam(Object value) {
        this.queryParams.add(value);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.source);
        hash = 67 * hash + Objects.hashCode(this.sqlQuery);
        hash = 67 * hash + Objects.hashCode(this.queryParams);
        hash = 67 * hash + Objects.hashCode(this.sink);
        hash = 67 * hash + Objects.hashCode(this.preRowTransformers);
        hash = 67 * hash + Objects.hashCode(this.entryTransformations);
        hash = 67 * hash + Objects.hashCode(this.postRowTransfomers);
        hash = 67 * hash + Objects.hashCode(this.expressions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JDBCPipeline other = (JDBCPipeline) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.sqlQuery, other.sqlQuery)) {
            return false;
        }
        if (!Objects.equals(this.queryParams, other.queryParams)) {
            return false;
        }
        if (!Objects.equals(this.sink, other.sink)) {
            return false;
        }
        if (!Objects.equals(this.preRowTransformers, other.preRowTransformers)) {
            return false;
        }
        if (!Objects.equals(this.entryTransformations, other.entryTransformations)) {
            return false;
        }
        if (!Objects.equals(this.postRowTransfomers, other.postRowTransfomers)) {
            return false;
        }
        if (!Objects.equals(this.expressions, other.expressions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JDBCPipeline{" + "name=" + name + ", source=" + source + ", sqlQuery=" + sqlQuery + ", queryParams=" + queryParams + ", sink=" + sink + ", preRowTransformers=" + preRowTransformers + ", entryTransformations=" + entryTransformations + ", postRowTransfomers=" + postRowTransfomers + ", expressions=" + expressions + '}';
    }
}
