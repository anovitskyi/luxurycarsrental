package dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class DaoImpl<T> implements CommonDao<T>
{
    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void add(T param)
    {
        sessionFactory.getCurrentSession().save(param);
    }

    @Override
    public void update(T param)
    {
        sessionFactory.getCurrentSession().update(param);
    }

    @Override
    public void delete(T param)
    {
        sessionFactory.getCurrentSession().delete(param);
    }

}
