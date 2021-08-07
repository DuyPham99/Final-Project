import '../Login/index.scss';
import LoginForm from './LoginForm';
import { useDispatch, useSelector } from 'react-redux';
import login from 'actions/login';
import { useHistory } from 'react-router-dom';
function Login(props) {
    const dispatch = useDispatch();
    const loginData = useSelector(state => state.login);
    const history = useHistory();
    const handleSubmit = (data) => {
        dispatch(login(data));
        if (loginData.accessToken) {
            history.replace("/");
        } else {
            history.replace("/dangnhap");
        }
    }
    return (
        <div className="sign-in">
            <LoginForm onSubmit={handleSubmit} />
        </div>
    );
}
export default Login;