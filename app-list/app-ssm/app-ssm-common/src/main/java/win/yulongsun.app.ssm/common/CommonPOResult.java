package win.yulongsun.common;

import win.yulongsun.constant.ResultConstant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author sunyulong on 2017/1/11.
 */
public class CommonPOResult<T> implements Serializable {
    private static final long serialVersionUID = 7827677657260653989L;

    private int       status; //表示返回结果的状态（成功、延时等等）
    private int       count;  //表示当前操作的数量
    private int       totalCount;//表示操作的总数
    private Exception exception;//表示出现的异常
    private String    message; //异常信息
    private int       page;       //返回页码数，在进行查询时，通过该参数可以让客户端知道该次的数据返回的是第几页的内容。
    private List<T> values = new ArrayList<T>();//实际持有的对象列表

    public CommonPOResult() {
        this.message = ResultConstant.MESSAGE.DEFAULT_ERROR_MESSAGE;
        this.status = ResultConstant.CODE.ERROR;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    /**
     * 返回当前Result实例持有的所有元素.
     * 返回的为内部元素的只读视图.
     * <p>
     *
     * @return 元素列表只读视图..
     */
    public List<T> getValues() {
        if (this.values != null) {
            List<T> result = new ArrayList<T>();
            result.addAll(this.values);
            return result;
        }
        return this.values;
    }

    /**
     * 设置Result实例持有的所有元素。
     * <p>
     *
     * @param values
     */
    public void setValues(List<T> values) {
        if (this.values.size() > 0) {
            this.values.clear();
        }
        this.values.addAll(values);
    }

    /**
     * 返回当前实例持有的首个对象.
     * <p>
     *
     * @return 首个对象.如果没有持有元素, 返回NULL.
     */
    public T getValue() {
        if (values.isEmpty()) {
            return null;
        } else {
            return values.get(0);
        }
    }

    /**
     * 将一个元素交给result实例.
     * <p>
     *
     * @param newValue 新的元素.
     */
    public void addValue(T newValue) {
        values.add(newValue);
    }

    @Override
    public String toString() {
        return "CommonResult{"
                + "status=" + status
                + ", count=" + count
                + ", totalCount=" + totalCount
                + ", exception=" + exception == null ? "NULL" : exception.getClass()
                + ", message=" + message
                + ", page=" + page
                + ", values=" + values.toString() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.status;
        hash = 47 * hash + this.count;
        hash = 47 * hash + this.totalCount;
        hash = 47 * hash + Objects.hashCode(this.exception);
        hash = 47 * hash + Objects.hashCode(this.message);
        hash = 47 * hash + this.page;
        hash = 47 * hash + Objects.hashCode(this.values);
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
        final CommonPOResult<?> other = (CommonPOResult<?>) obj;
        if (this.status != other.status) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (this.totalCount != other.totalCount) {
            return false;
        }
        if (!Objects.equals(this.exception, other.exception)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (this.page != other.page) {
            return false;
        }
        if (!Objects.equals(this.values, other.values)) {
            return false;
        }
        return true;
    }

}
