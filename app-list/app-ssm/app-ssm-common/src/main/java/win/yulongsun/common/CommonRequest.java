package win.yulongsun.common;

import java.io.Serializable;

/**
 * @author sunyulong on 2017/1/11.
 */
public class CommonRequest implements Serializable {

    //表示查询的页码
    private int page = 0;

    //表示每页的个数
    private int pageSize = 10;

    //表示开始查询的索引号
    private int start = -1;

    /**
     * 表示查询是否分页。
     * 如果值为true，表示结果分页；
     * 如果结果不为true，则结果不分页，取所有结果。
     */
    private boolean isPaging = true;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * 如果需要分页，可以通过该方法获得该页的第一个数据的行数
     * <p>
     * 判断的条件是 >= getStart
     *
     * @return
     */
    public int getStart() {
        if (start < 0) {
            return page * pageSize;
        } else {
            return start;
        }
    }

    public void setStart(int start) {
        this.start = start;
    }

    public boolean isPaging() {
        return isPaging;
    }

    public void setPaging(boolean paging) {
        isPaging = paging;
    }
}
