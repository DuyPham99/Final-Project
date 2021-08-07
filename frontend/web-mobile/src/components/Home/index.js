import Banner from "components/Banner";
import CLients from "components/Clients";
import '../Home/index.scss';
import Products from '../Products/index';
function Home() {
    return (
        <div className="body">
            <Banner />
            <Products />
            <CLients />
        </div>
    );
}
export default Home;