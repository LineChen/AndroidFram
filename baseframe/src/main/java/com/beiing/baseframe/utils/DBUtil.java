package com.beiing.baseframe.utils;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

/**
 * Created by chenliu on 2016/4/21.
 * 描述：数据库操作工具
 */
public class DBUtil {
    private static DbManager.DaoConfig config;

    private static DbManager manager;
    private static final String DB_NAME = "app_db";

    private DBUtil() {
    }

    public static DBUtil getInstance() {
        init();
        return DBUtilHolder.instance;
    }

    private static class DBUtilHolder{
        private static final DBUtil instance = new DBUtil();
    }

    public static void init() {
        if (null == config)
            config = new DbManager.DaoConfig()
                    .setDbName(DB_NAME)
                    .setDbVersion(1)
                    .setDbOpenListener(new DbManager.DbOpenListener() {
                        @Override
                        public void onDbOpened(DbManager db) {
                            // 开启WAL, 对写入加速提升巨大
                            db.getDatabase().enableWriteAheadLogging();
                        }
                    });
        manager = x.getDb(config);
    }

    public void save(Object obj) {
        try {
            manager.save(obj);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void saveOrupdate(Object obj){
        try {
            manager.saveOrUpdate(obj);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    public void delete(Object obj) {
        try {
            manager.delete(obj);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> findAll(Class<T> clz) {
        try {
            if (null != manager.getTable(clz)) {
                return manager.findAll(clz);
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> findAllBy(Class<T> clz, WhereBuilder builder) {
        try {
            return manager.selector(clz).where(builder).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T find(Class<T> clz, WhereBuilder builder) {
        try {
            return manager.selector(clz).where(builder).findFirst();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T findFirst(Class<T> clz) {
        try {
            return manager.selector(clz).orderBy("_id", true).findFirst();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clear(Class clz) {
        try {
            manager.delete(clz);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


}
