import AuthButton from "@/components/button/authButton";
import AuthInput from "@/components/input/authInput";

export default function LoginPage() {
  return (
    <div className="flex min-h-screen items-center justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        <img
          alt="Your Company"
          src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600"
          className="mx-auto h-10 w-auto"
        />
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
          Sign in to your account
        </h2>
        <form action="#" method="POST" className="mt-10 space-y-6">
          <div>
            <label htmlFor="email" className="block text-sm font-medium leading-6 text-gray-900">
              Email address
            </label>
            <div className="mt-2">
              <AuthInput
                id="email"
                name="email"
                type="email"
                required={true}
                autoComplete="email"
              />
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <label htmlFor="password" className="block text-sm font-medium leading-6 text-gray-900">
                Password
              </label>
              <div className="text-sm">
                <a href="#" className="font-semibold text-indigo-600 hover:text-indigo-500">
                  Forgot password?
                </a>
              </div>
            </div>
            <div className="mt-2">
              <AuthInput
                id="password"
                name="password"
                type="password"
                required={true}
                autoComplete="current-password"
              />
            </div>
          </div>

          <div>
            <AuthButton type="submit" className="my-custom-class">
              Sign in
            </AuthButton>
          </div>
        </form>
      </div>
    </div>
  )
}
